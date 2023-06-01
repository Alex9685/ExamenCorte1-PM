package com.example.examencorte1


class Rectangulo {
    private var base: Int
    private var altura: Int

    constructor() {
        base = 0
        altura = 0
    }

    fun calcularArea(): Float {
        return base.toFloat() * altura.toFloat()
    }

    fun calcularPagPerimetro(): Float {
        return 2 * (base.toFloat() + altura.toFloat())
    }
}
