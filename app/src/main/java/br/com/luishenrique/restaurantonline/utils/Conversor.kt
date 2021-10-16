package br.com.luishenrique.restaurantonline.utils

import java.math.BigDecimal

fun BigDecimal.toReais(): String {
    return "R$${this}"
}