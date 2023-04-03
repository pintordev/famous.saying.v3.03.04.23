package application;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> parameterBitsMap;
    private String[] commandsUsingId = {"delete", "modify"};

    public Request(String command) {

        String[] commandBits = command.split("\\?", 2);
        this.actionCode = commandBits[0];

        if (commandBits.length == 1) {
            for (String commandUsingId : this.commandsUsingId) {
                if (commandUsingId.equals(this.actionCode)) { // delete만 입력된 경우, this.parameterBitsMap == null
                    System.out.printf("Please enter the valid %s command form. (e.g. %s?id=1)\n", this.actionCode, this.actionCode);
                }
            }
            return;
        }

        String[] parameters = commandBits[1].split("&");

        this.parameterBitsMap = new HashMap<>();

        for (String parameter : parameters) {
            String[] parameterBits = parameter.split("=", 2);

            if (parameterBits.length == 1) { // errore case #2 delete?, delete?xxx 형태 입력, this.parameterBitsMap이 이미 선언된 형태여서 값이 null이 아니라 비어있는 형태
                System.out.printf("Please enter the valid %s command form. (e.g. %s?id=1)\n", this.actionCode, this.actionCode);
                return;
            }

            this.parameterBitsMap.put(parameterBits[0], parameterBits[1]);
        }
    }

    public String getActionCode() {
        return this.actionCode;
    }

    public String getParameter(String key) {
        try {
            return this.parameterBitsMap.get(key);
        } catch (NullPointerException e) { // this.parameterBitsMap이 선언된 이후인 error case #2는 여기를 통과
            return "-1";
        }
    }

    public long getLongParameter(String key, long defaultValue) {
        try {
            return Long.parseLong(getParameter(key));
        } catch (NumberFormatException e) {
            if (!this.parameterBitsMap.isEmpty()) { // error case #2 여기서 거름
                System.out.println("Please enter the number type id."); // id= 이후 값에 관한 에러 발생 시에만 메시지 출력
            }
            return defaultValue;
        }
    }
}
