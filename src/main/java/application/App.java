package application;

import application.famousSaying.controller.FamousSayingController;
import application.sytem.controller.SystemController;

public class App {
    public static void run() {
        SystemController systemController = new SystemController();
        FamousSayingController famousSayingController = new FamousSayingController();

        systemController.init();

        while (true) {
            Request request = new Request(systemController.getCommand());

            switch (request.getActionCode()) {
                case "terminate":
                    systemController.terminate();
                    return;
                case "register":
                    famousSayingController.register();
                    break;
                case "list":
                    famousSayingController.list();
                    break;
                case "delete":
                    famousSayingController.delete(request);
                    break;
                case "modify":
                    famousSayingController.modify(request);
                    break;
                case "help":
                    systemController.help();
                    break;
                default:
                    systemController.error();
                    break;
            }
        }
    }
}
