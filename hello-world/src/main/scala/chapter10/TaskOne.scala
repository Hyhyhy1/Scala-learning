package chapter10

trait RectangleLike {
    def getX: Double
    def getY: Double
    def getWidth: Double
    def getHeight: Double
    def setFrame(x: Double, y: Double, w: Double, h: Double): Unit

    def translate(dx: Double, dy: Double) : Unit = {
        setFrame(getX + dx, getY + dy, getWidth, getHeight)
    }

    def grow(dw: Double, dh: Double) = {
        setFrame(getX - dw, getY - dh, getWidth + 2 * dw, getHeight + 2 * dh)
    }
}
