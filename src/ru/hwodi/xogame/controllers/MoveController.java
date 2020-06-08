package ru.hwodi.xogame.controllers;

import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.AlreadyOccupiedException;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

public class MoveController {
    public void applyFigure(final Field field, final Point point, final Figure figure) throws AlreadyOccupiedException, InvalidePointException {
        field.setFigure(point, figure);
    }
}
