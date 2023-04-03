package application.famousSaying.controller;

import application.Container;
import application.Request;
import application.Util;
import application.famousSaying.entity.FamousSaying;

import java.util.ArrayList;
import java.util.List;

public class FamousSayingController {
    private long id = 1;
    private List<FamousSaying> sayingList = new ArrayList<>();

    public void register() {
        System.out.println("=".repeat(31));
        System.out.printf("Famous Saying: ");
        String contents = Container.getScanner().nextLine().trim();
        System.out.printf("Author: ");
        String author = Container.getScanner().nextLine().trim();
        this.sayingList.add(new FamousSaying(this.id, author, contents));
        System.out.printf("%s famous saying has been registered.\n", Util.ordinal(this.id++));
    }

    public void list() {
        if (this.sayingList.size() > 0) {
            System.out.println("=".repeat(31));
            System.out.println("Id / Author / Famous Saying");
            System.out.println("-".repeat(27));
            for (int i = this.sayingList.size() - 1; i >= 0; i--) {
                System.out.println(this.sayingList.get(i).getList());
            }
        } else {
            System.out.println("There is no list in this application.");
        }
    }

    public void delete(Request request) {
        long deleteId = request.getLongParameter("id", -1);

        if (deleteId == -1) return;

        FamousSaying famousSayingDelete = this.findById(deleteId);

        if (famousSayingDelete != null) {
            this.sayingList.remove(famousSayingDelete);
            System.out.printf("%s famous saying has been deleted.\n", Util.ordinal(deleteId));
        } else {
            System.out.printf("%s famous saying does not exist.\n", Util.ordinal(deleteId));
        }
    }

    public void modify(Request request) {
        long modifyId = request.getLongParameter("id", -1);

        if (modifyId == -1) return;

        FamousSaying famousSayingModify = this.findById(modifyId);

        if (famousSayingModify != null) {
            System.out.printf("Famous Saying (present): %s\n", famousSayingModify.getContents());
            System.out.printf("Famous Saying (to be modified): ");
            famousSayingModify.setContents(Container.getScanner().nextLine().trim());

            System.out.printf("Author (present): %s\n", famousSayingModify.getAuthor());
            System.out.printf("Author (to be modified): ");
            famousSayingModify.setAuthor(Container.getScanner().nextLine().trim());

            System.out.printf("%s famous saying has been modified.\n", Util.ordinal(modifyId));
        } else {
            System.out.printf("%s famous saying does not exist.\n", Util.ordinal(modifyId));
        }
    }

    public FamousSaying findById(long id) {
        for (FamousSaying famousSaying : this.sayingList) {
            if (famousSaying.getId() == id) {
                return famousSaying;
            }
        }
        return null;
    }

}
