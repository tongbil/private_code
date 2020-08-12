package com.google.demoForIdea.meiju;
public interface DicStudent {

	/**
	 * 性别 : {男:1, 女:2}
	 */
	enum Gender implements IDictItem {

		man("1", "男"), woman("2", "女");

		Gender(String value, String label) {
			StaticDictPool.putDictItem(this, value, label);
		}
	}

	/**
	 * 状态
	 */
	enum State implements IDictItem {

		notReported("10", "未报到"),
		reading("20", "在读"),
		graduation("30", "毕业"),
		defamation("40", "肄业"),
		completion ("50", "肄业"),
		withdrawal("60", "退学"),
		expulsion("70", "开除");

		State(String value, String label) {
			StaticDictPool.putDictItem(this, value, label);
		}
	}
}