package ge.edu.btu.chat.server;

public class BankChat {
    float exchangeRate = 0f;
    String[] branches = { "Tbilisi", "Batumi" };

    BankChat(float exchangeRate){
        this.exchangeRate = exchangeRate;
    }

    public String readAndRespondToMessage(String msg){
        return switch (msg.toLowerCase()) {
            case "hi", "hello" -> "Hello, welcome to bank";
            case "exchange", "exchange rate" -> Float.toString(exchangeRate);
            case "branches", "show branches" -> getBranches();
            default -> "I have no answer to that!";
        };

    }

    public String getBranches(){
        String allBranches = "";

        for(int i = 0; i <= branches.length; i++){
            allBranches = allBranches + branches[i] + " ";
        }

        return allBranches;
    }
}
