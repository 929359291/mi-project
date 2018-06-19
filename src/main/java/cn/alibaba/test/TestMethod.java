package cn.alibaba.test;

/**
 * @author zengxc
 * @since 2018/6/7
 **/
public class TestMethod {

    public void test01() {
        System.out.println(RepayType.NORMAL.getValue("R01"));
    }

    public enum RepayType{
        // 正常还款
        NORMAL("1"),

        // 提前还款
        ADVANCE("2"),

        // 逾期还款
        OVERDUE("3");

        private final String type;

        private final String[] REQ_TYPES = {"R01", "R02", "R03"};

        RepayType(String type){
            this.type = type;
        }

        public String getValue(String reqType){
            if (REQ_TYPES[0].equals(reqType)){
                return NORMAL.getType();
            } else if (REQ_TYPES[1].equals(reqType)){
                return ADVANCE.getType();
            } else {
                return OVERDUE.getType();
            }
        }

        public String getType(){
            return this.type;
        }
    }
}
