package itmo.gorhskov.tpo.task3;

public class Editor extends Human {
    public InformationType checkInformation(Information information) {
        if (information.getPayload().contains("bump")) {
            return InformationType.ENTERTAINING;
        }
        if (information.getPayload().contains("cry")) {
            return InformationType.SAD;
        }
        if (information.getPayload().contains("haha")) {
            return InformationType.FUNNY;
        }
        return InformationType.ORDINARY;
    }

    public boolean checkIfBookEntertaining(Book book) {
        return book.getInformation().stream()
                .anyMatch(information -> checkInformation(information).equals(InformationType.ENTERTAINING));
    }
}
