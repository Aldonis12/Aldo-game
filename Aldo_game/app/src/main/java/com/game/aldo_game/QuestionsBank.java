package com.game.aldo_game;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> MisomaQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        //creation des questions reponses
        final QuestionsList question1 = new QuestionsList("Madagascar est surnommée Grande Île. Ce surnom lui va bien car elle est la :", "3e plus grande île de la planète","5e plus grande île de la planète", "7e plus grande île de la planète", " Aucun", "5e plus grande île de la planète", "");
        final QuestionsList question2 = new QuestionsList("Dans quel océan l'île de Madagascar est-elle située ?", "Indien","Pacifique", "Antarctique", "Atlantique", "Indien", "");
        final QuestionsList question3 = new QuestionsList("Quelle est la superficie totale de Madagascar ?", "476 196 km²","587 040 km²", " 692 483 km²", " 792 690 km²", "587 040 km²", "");
        final QuestionsList question4 = new QuestionsList("Quelle est la population de Madagascar en 2010 ?", "21 281 844 habitants","28 566 732 habitants", "24 621 883 habitants", "18 421 974 habitants", "21 281 844 habitants", "");
        final QuestionsList question5 = new QuestionsList("les Malgaches fêtent la commémoration de la signature de l'acte d'indépendance de l'île de la colonisation française le :", "26 juin","14 juillet", "12 août", "25 décembre", "26 juin", "");
        final QuestionsList question6 = new QuestionsList("Comment se nomme la vieille tradition des tribus malgaches consistant à envelopper des ossements dans de la soie ?", "Tromba","Famadihana", "Morengy", "Zanahary", "Famadihana", "");
        /*final QuestionsList question7 = new QuestionsList("Comment appelle t-on notre fameux grand-père?", "Commissaire","Andriamamonjy Christopher", "Ray Aman-dReny", "Randriamamonjy Christopher", "Randriamamonjy Christopher", "");
        final QuestionsList question8 = new QuestionsList("quel est le meilleur Chiffre :", "21","28", "83", "aucun", "aucun", "");
        final QuestionsList question9 = new QuestionsList("que signifie TSESSS ?", "Aonaaaa?","Tsisy idirany", "kdj", "merci ty", "Tsisy idirany", "");
         */
        //ajout des questions dans la liste

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        /*questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);>
         */

        return questionsLists;
    }

    /*public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "java":
                return javaQuestions();
            case "html":
                return htmlQuestions();
            case "php":
                return phpQuestions();
            default:
                return MisomaQuestions();
        }
    }*/

    public static List<QuestionsList> getQuestions(){
        return MisomaQuestions();
    }
}
