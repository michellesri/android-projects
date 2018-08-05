package com.github.michellesri.tetris;

import android.graphics.Color;

public enum GamePiece {

    /*
    x_
    x_
    xx
    --
     */
    LEFT_L(
            new boolean[][] {
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.BLUE
    ),

    /*
    _x
    _x
    xx
    __
     */
    RIGHT_L(
            new boolean[][] {
                    new boolean[] {
                            false, true
                    },
                    new boolean[] {
                            false, true
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.GREEN
    ),

    /*
    xx
    xx
    __
    __
     */
    SQUARE(
            new boolean[][] {
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            false, false
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.RED
    ),

    /*
    x_
    x_
    x_
    x_
     */
    LONG(
            new boolean[][] {
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, false
                    }
            },
            Color.YELLOW
    ),

    /*
    _x
    xx
    x_
    __
     */
    LEFT_Z(
            new boolean[][] {
                    new boolean[] {
                            false, true
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.GRAY
    ),

    /*
    x_
    xx
    _x
    __
     */
    RIGHT_Z(
            new boolean[][] {
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            false, true
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.MAGENTA
    ),

    /*
    x_
    xx
    x_
    __
     */
    T(
            new boolean[][] {
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            true, true
                    },
                    new boolean[] {
                            true, false
                    },
                    new boolean[] {
                            false, false
                    }
            },
            Color.CYAN
    );

    public final boolean[][] tileMatrix;
    public final int color;

    /**
     * Each GamePiece enum is going to have a 2 width x 4 height matrix representing its shape,
     * thus 4 rows and 2 columns.
     */
    GamePiece(boolean[][] tileMatrix, int color) {
        if (tileMatrix.length != 4 || tileMatrix[0].length != 2) {
            throw new IllegalArgumentException("Not valid tileMatrix");
        }

        this.tileMatrix = tileMatrix;
        this.color = color;
    }

}
