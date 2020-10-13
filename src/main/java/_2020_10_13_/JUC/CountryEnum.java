package _2020_10_13_.JUC;

public enum CountryEnum {
    ONE(1, "齐"), TWO(2,"楚"), THREE(3, "燕"),
    FOUR(4, "赵"), FIVE(5,"魏"), SIX(6,"韩");

    private Integer returnCode;
    private String returnMessage;

    CountryEnum(Integer returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public static CountryEnum for_eachCountryEnum(Integer index){
        CountryEnum[] countryEnum = CountryEnum.values();
        for(CountryEnum element: countryEnum){
            if(element.getReturnCode().equals(index)){
                return element;
            }
        }
        return null;
    }
}
