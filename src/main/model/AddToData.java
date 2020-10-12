package model;

import java.util.List;

public class AddToData {

    public AddToData(DataChoices dc, List<Object> list) {

        list.add(new DataChoices("esports", "cs", "canada", "ubc"));
        list.add(new DataChoices("soccer", "math", "usa", "berkley"));

    }
}
