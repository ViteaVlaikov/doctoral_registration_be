package usm.api.doctoral_registration.crosstab;

import lombok.AllArgsConstructor;

public interface CrossTab {

    @AllArgsConstructor
    class Item {

        Cell col;

        Cell  row;

        Integer value;
    }

    @AllArgsConstructor
    class Cell {

        String value;

        String param;

        Float id;
    }
}
