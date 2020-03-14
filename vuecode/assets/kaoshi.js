const { openBrowser, goto, click, inputField, write, link, contains, text, doubleClick } = require('taiko');
const { writeFileSync,mkdir } = require('fs');
const {encode }=require('iconv-lite');
const userlist = ['718466', '736117'];
const shijiuan = "2018年度全行科技开发大赛";

async function getshijuan(userid) {
    try {
        console.time(userid);

        await goto("http://www.training.cebbank.com/");
        try {
            link("退出").exists();
            await click("退出");
            await accept();
        } catch (e) {
            console.error(e);
        }
        await click("登录");
        await write(userid, inputField({ name: 'name' }));
        await write(userid, inputField({ name: 'pwd' }));
        await click(inputField({ type: "submit" }));
        await click("在线考试");
        try {
            await contains(shijiuan).exists();
            await click(link(contains(shijiuan)));
        } catch (e) {
            console.log("没有找到试卷【" + shijiuan + "】");
            return false;
        }
        await accept();
        try {
            await inputField({value:"进入考试"}).value();
            console.log("还没有考试过");
            return false;
        } catch (e) {
            console.log("可以查看考试");
        }
        await evaluate(() => {
            var sourcecode = document.getElementsByTagName('html')[0].innerHTML;
            console.log(sourcecode);
            var res = sourcecode.match(/document.form1.action="(.*)";\/\/修改及查看作业/);
            console.log(res);
            document.form1.action = res[1];
            document.form1.submit();
            return document.title
        });
        await evaluate(() => {
            return document.body.outerText;
        }).then((mm) => {
            writeFileSync("./" + userid + ".txt",encode(mm.result,'gb2312'));
        });

        console.timeEnd(userid);
    } catch (e) {
        console.error(e);
    }

};

const getallshijuan = async () => {
    console.time("getallshijuan");
    await openBrowser();
    for (const item of userlist) {
        await getshijuan(item);
    }
    await closeBrowser();
    console.timeEnd("getallshijuan");
};

getallshijuan();
