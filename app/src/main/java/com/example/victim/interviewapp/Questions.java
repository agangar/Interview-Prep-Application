package com.example.victim.interviewapp;

public class Questions {

    public String mQuestions[] = {
            "Do array subscripts always start with zero?",
            "How can I remove the trailing spaces from a string?",
            "How long is an IPv6 address?",
            "Before launching a software which testing is to be done in-house?",
            "Find the number of integers satisfying the inequality (x2+x-6) (x2-x-20) <0?",
            "The value of x given 3x+1 + 32x +1 = 270?",
            "What is the possibility of having 53 Thursdays in a non-leap year?",
            "When is the type checking usually done?",
            "For predictive parsing the grammar A->AA I (A) I ε is not suitable because?",
            "Let computer A and computer B that have the IP addresses 10.105.1.113 and 10.105.1.91 respectively use the same net mask N. For A and B to belong to same network, the value of N should not be ",
            "For the application layer in the Internet stack, the protocol data unit (PDU) is",
            "What is the use of address resolution protocol (ARP)?"

    };

    private String mChoices[][] = {
            { "No", "Yes", "Maybe","None"},
            { "artrim", "rtrim", "strim","trim"},
            { "32 bits", "128bytes","64 bits","128bits"},
            { "Beta","Gamma","Alpha","None"},
            {"4","2","0","Infinite"},
            {"2","3","1","0"},
            {"6/7","1/7","1/365","53/365"},
            {"During syntax directed translation","During lexical analysis","During code optimization","During syntax analysis"},
            {"The grammar is left recursive","The grammar is ambiguous","The grammar is right recursive","The grammar is operator grammar"},
            {"255.255.255.224","255.255.255.0","255.255.255.128","255.255.255.192"},
            {"Datagram","Message","Frame","Segment"},
            {"To find the MAC address corresponding to an IP address.","To find an IP address corresponding to the MAC address","To find the IP address from the DNS","To find the IP address of the default gateway"}

    };

    private String mCorrectAnswers[] = {"Yes","rtrim","128bits","Alpha","2","2","1/7","During syntax directed translation","The grammar is left recursive","255.255.255.224","Message","To find the MAC address corresponding to an IP address."};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }


    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }



}