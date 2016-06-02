package com.alee.laf.label;

import java.awt.*;

/**
 * Describes common component rotation options.
 *
 * @author Alexandr Zernov
 * @author Mikle Garin
 */

public enum Rotation
{
    /**
     * No rotation.
     */
    none,

    /**
     * 90 degrees clockwise rotation.
     * In case with label - first character at top and last one at bottom.
     */
    clockwise,

    /**
     * 90 degrees counter-clockwise rotation.
     * In case with label - first character at bottom and last one at top.
     */
    counterClockwise,

    /**
     * 180 degrees rotation.
     * In case with label - it will be displayed upside down.
     */
    upsideDown;

    /**
     * Return whether orientation vertical or not.
     *
     * @return whether orientation vertical or not.
     */
    public boolean isVertical ()
    {
        return this == Rotation.clockwise || this == Rotation.counterClockwise;
    }

    /**
     * Returns opposite orientation.
     *
     * @return opposite orientation
     */
    public Rotation rightToLeft ()
    {
        switch ( this )
        {
            case clockwise:
                return counterClockwise;

            case counterClockwise:
                return clockwise;

            default:
                return this;
        }
    }

    /**
     * Returns rectangle transposed according to rotation.
     *
     * @param rectangle rectangle to transpose
     * @return rectangle transposed according to rotation
     */
    public Rectangle transpose ( final Rectangle rectangle )
    {
        return isVertical () ? new Rectangle ( rectangle.x, rectangle.y, rectangle.height, rectangle.width ) : rectangle;
    }

    /**
     * Returns dimension transposed according to rotation.
     *
     * @param dimension dimension to transpose
     * @return dimension transposed according to rotation
     */
    public Dimension transpose ( final Dimension dimension )
    {
        return isVertical () ? new Dimension ( dimension.height, dimension.width ) : dimension;
    }
}