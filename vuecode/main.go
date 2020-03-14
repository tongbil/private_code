package main

import (
	"bufio"
	"fmt"
	"os"
	"path"

	"github.com/mkideal/cli"

	"os/exec"
	"runtime"

	"github.com/flosch/pongo2"
	"github.com/goware/set"
	"github.com/tealeg/xlsx"
)

var commands = map[string]string{
	"windows": "cmd /c start",
	"darwin":  "open",
	"linux":   "xdg-open",
}

// Open calls the OS default program for uri
func Open(uri string) error {
	run, ok := commands[runtime.GOOS]
	if !ok {
		return fmt.Errorf("don't know how to open things on %s platform", runtime.GOOS)
	}

	cmd := exec.Command(run, uri)
	return cmd.Start()
}

func PathExists(path string) (bool, error) {
	_, err := os.Stat(path)
	if err == nil {
		return true, nil
	}
	if os.IsNotExist(err) {
		return false, nil
	}
	return false, err
}

type argT struct {
	cli.Helper
	ConfigFile string `cli:"*c,configfile" usage:"指定配置文件路径"`
	Tphtml     string `cli:"tphtml" usage:"指定html模板文件" dft:"./indextemplet.html"`
	Tpjs       string `cli:"tpjs" usage:"指定js模板文件" dft:"./indextemplet.js"`
	Od         string `cli:"od" usage:"生成的文件路径" dft:"./"`
	Of         string `cli:"*of" usage:"生成的文件名,不需要后缀名"`
	O          bool   `cli:"o" usage:"文件生成后，系统默认浏览器打开"`
	F          bool   `cli:"f" usage:"默认覆盖文件，不提示"`
}

func gen(argv *argT) {
	genhtml_f := true
	genjs_f := true
	excelFileName := argv.ConfigFile
	tphtml := argv.Tphtml
	tpjs := argv.Tpjs
	od := argv.Od
	of := argv.Of

	xlFile, err := xlsx.OpenFile(excelFileName)
	if err != nil {
		fmt.Println("打开配置文件失败！")
		os.Exit(1)
	}

	//	config_map的结构
	//	{
	//		pagexx:value,
	//		tablexx:value,
	//		table:[],
	//		searchForm:[],
	//		createForm:[],
	//		updateForm:[],
	//		codetableget:value
	//	}

	config_map := pongo2.Context{}
	var searchForm_keys []string
	var table_keys []string
	var createForm_keys []string
	var updateForm_keys []string
	codetableget_set := set.NewStringSet()
	for _, sheet := range xlFile.Sheets {
		if sheet.Name == "基本配置" {
			for _, row := range sheet.Rows[1:] {
				config_map[row.Cells[0].Value] = row.Cells[2].Value
			}

		}

		if sheet.Name == "查询表单" {
			row3 := sheet.Rows[2]
			keys_len := len(row3.Cells)
			searchForm_keys = make([]string, keys_len)
			for index, cell := range row3.Cells {
				searchForm_keys[index] = cell.Value
			}
			//读取各个字段的配置信息
			if len(sheet.Rows) > 3 {
				searchForm := make([]pongo2.Context, len(sheet.Rows)-3)
				for row_index, row := range sheet.Rows[3:] {
					searchForm_item := pongo2.Context{}
					for index, cell := range row.Cells {
						searchForm_item[searchForm_keys[index]] = cell.Value
					}
					searchForm[row_index] = searchForm_item
					codetableget_set = gen_codetable(searchForm_item, codetableget_set)
				}
				config_map["searchForm"] = searchForm

			}

		}

		if sheet.Name == "查询结果表格" {
			row2 := sheet.Rows[1]
			keys_len := len(row2.Cells)
			table_keys = make([]string, keys_len)
			for index, cell := range row2.Cells {
				table_keys[index] = cell.Value
			}

			//读取各列的配置信息
			if len(sheet.Rows) > 2 {
				table := make([]pongo2.Context, len(sheet.Rows)-2)
				for row_index, row := range sheet.Rows[2:] {
					table_item := pongo2.Context{}
					for index, cell := range row.Cells {
						table_item[table_keys[index]] = cell.Value
					}
					table[row_index] = table_item
				}
				config_map["table"] = table

			}

		}

		if sheet.Name == "新建表单" && config_map["page_addbutton"] == "是" {
			row3 := sheet.Rows[2]
			keys_len := len(row3.Cells)
			createForm_keys = make([]string, keys_len)
			for index, cell := range row3.Cells {
				createForm_keys[index] = cell.Value
			}

			//读取各个字段的配置信息
			if len(sheet.Rows) > 3 {
				createForm := make([]pongo2.Context, len(sheet.Rows)-3)
				for row_index, row := range sheet.Rows[3:] {
					createForm_item := pongo2.Context{}
					for index, cell := range row.Cells {
						createForm_item[createForm_keys[index]] = cell.Value
					}
					createForm[row_index] = createForm_item
					codetableget_set = gen_codetable(createForm_item, codetableget_set)
				}
				config_map["createForm"] = createForm

			}

		}

		if sheet.Name == "编辑表单" && config_map["page_editbutton"] == "是" {
			row3 := sheet.Rows[2]
			keys_len := len(row3.Cells)
			updateForm_keys = make([]string, keys_len)
			for index, cell := range row3.Cells {
				updateForm_keys[index] = cell.Value
			}

			//读取各个字段的配置信息
			if len(sheet.Rows) > 3 {
				updateForm := make([]pongo2.Context, len(sheet.Rows)-3)
				for row_index, row := range sheet.Rows[3:] {
					updateForm_item := pongo2.Context{}
					for index, cell := range row.Cells {
						updateForm_item[updateForm_keys[index]] = cell.Value
					}
					updateForm[row_index] = updateForm_item
					codetableget_set = gen_codetable(updateForm_item, codetableget_set)
				}
				config_map["updateForm"] = updateForm
			}
		}
	}
	config_map["codetableget"] = codetableget_set
	config_map["ofjs"] = of + ".js"
	exists, _ := PathExists(of + ".html")
	if exists && !argv.F {
		var is_yes string
		fmt.Printf("是否覆盖 %s （N/Y）：", of+".html")
		fmt.Scanln(&is_yes)
		if is_yes != "Y" {
			fmt.Println("不覆盖")
			genhtml_f = false
		}
	}
	//****************************HTML生成****************************//
	if genhtml_f {

		tpl, err := pongo2.FromFile(tphtml)
		if err != nil {
			fmt.Println("读取html模板文件失败")
			os.Exit(1)
		}
		o_f, err := os.Create(path.Join(od, of+".html"))
		if err != nil {
			fmt.Println("创建html文件失败")
			os.Exit(1)
		}

		defer o_f.Close()

		of_writer := bufio.NewWriter(o_f)
		err = tpl.ExecuteWriter(config_map, of_writer)
		if err != nil {
			panic(err)
		}
	}
	//****************************js生成****************************//
	exists, _ = PathExists(of + ".js")
	if exists && !argv.F {
		var is_yes string
		fmt.Printf("是否覆盖 %s （N/Y）：", of+".js")
		fmt.Scanln(&is_yes)
		if is_yes != "Y" {
			fmt.Println("不覆盖")
			genjs_f = false
		}
	}
	if genjs_f {
		tpl, err := pongo2.FromFile(tpjs)
		if err != nil {
			fmt.Println("读取js模板文件失败")
			os.Exit(1)
		}
		o_f, err := os.Create(path.Join(od + of + ".js"))
		if err != nil {
			fmt.Println("创建js文件失败")
			os.Exit(1)
		}

		defer o_f.Close()

		of_writer := bufio.NewWriter(o_f)
		err = tpl.ExecuteWriter(config_map, of_writer)
		if err != nil {
			panic(err)
		}
	}
	if argv.O {
		Open(path.Join(od + of + ".html"))
	}

}

func main() {
	cli.Run(new(argT), func(ctx *cli.Context) error {
		argv := ctx.Argv().(*argT)
		gen(argv)
		return nil
	})

}
func gen_codetable(form_item pongo2.Context, str_set set.StringSet) set.StringSet {
	if (form_item["type"].(string) == "下拉列表框") && (form_item["select_code"].(string) != "") {
		str_set = str_set.Add(form_item["select_code"].(string))
	}
	if (form_item["type"].(string) == "多选框") && (form_item["checkbox_code"].(string) != "") {
		str_set = str_set.Add(form_item["checkbox_code"].(string))
	}
	if (form_item["type"].(string) == "单选框") && (form_item["radio_code"].(string) != "") {
		str_set = str_set.Add(form_item["radio_code"].(string))
	}
	return str_set
}
