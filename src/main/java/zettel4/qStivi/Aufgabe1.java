package zettel4.qStivi;

public class Aufgabe1 {
    public static void main(String[] args) {
        showBillboard("According to all known laws of aviation, there is no way a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway because bees don't care what humans think is impossible.");
        showBillboard("Testing your own code with all kinds of different values is important!");
        showBillboard("Testing your own code is important!");
        showBillboard("");
        showBillboard("€");
    }

    private static void showBillboard(String message) {
        var length = message.length();
        var toSmall = false;
        if (length < 17) {
            length = 17;
            toSmall = true;
        }
        var offset = length / 2;

        var hair = "\\|||||/";
        var face = "( O O )";
        var signLine1 = "ooO-----(_)--------";
        var signLine2 = "";
        var signLine3 = message;
        var signLine5 = "----------------Ooo";
        var upperLegs = "|_| |_|";
        var lowerLegs = "|| ||";
        var feet = "ooO Ooo";

        while (face.length() - 6 < offset) {
            hair = " " + hair;
            face = " " + face;
            feet = " " + feet;
            upperLegs = " " + upperLegs;
        }
        while (lowerLegs.length() - 5 < offset) {
            lowerLegs = " " + lowerLegs;
        }

        while (signLine1.length() - 2 < length) {
            signLine1 = "-" + signLine1 + "-";
            signLine5 = "-" + signLine5 + "-";
        }
        while (signLine2.length() - 2 < length) {
            signLine2 = " " + signLine2;
        }

        if (toSmall) {
            while (signLine3.length() < length) {
                signLine3 = " " + signLine3 + " ";
            }
            if (message.length() % 2 == 1) {
                signLine3 = "| " + signLine3 + " |";
            } else {
                signLine3 = "| " + signLine3 + "|";
            }
        } else {
            if (length % 2 == 0) {
                signLine2 = " " + signLine2;
                signLine3 = "|  " + signLine3 + " |";
            } else {
                signLine3 = "| " + signLine3 + " |";
            }
        }

        signLine2 = "|" + signLine2 + "|";
        signLine5 = "|" + signLine5 + "|";
        signLine1 = "|" + signLine1 + "|";

        System.out.println(hair);
        System.out.println(face);
        System.out.println(signLine1);
        System.out.println(signLine2);
        System.out.println(signLine3);
        System.out.println(signLine2);
        System.out.println(signLine5);
        System.out.println(upperLegs);
        System.out.println(lowerLegs);
        System.out.println(feet);
    }
}
