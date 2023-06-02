package com.example.examencorte1


class Rectangulo {
    public var base: Int
    public var altura: Int

    constructor() {
        base = 0
        altura = 0
    }

    fun calcularArea(): Int {
        return base.toInt() * altura.toInt()
    }

    fun calcularPagPerimetro(): Int {
        return 2 * (base.toInt() + altura.toInt())
    }
}
