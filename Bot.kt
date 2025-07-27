package com.example.swaragame

class Bot(val name: String) : Player(name) {

    fun decideToPass(): Boolean {
        // Bot 50% ýagdaýda geçýär, 50% goýýar
        return (0..1).random() == 0
    }

    fun decideToRespondToSwara(): Boolean {
        // Bot "Swara" jogaby üçin %70 howa, %30 ýok diýýär
        return (0..9).random() < 7
    }

    fun makeMove(): String {
        return if (decideToPass()) {
            "Geçdi"
        } else {
            "Goýdy"
        }
    }

    fun respondToSwaraRequest(): String {
        return if (decideToRespondToSwara()) {
            "Howa"
        } else {
            "Ýok"
        }
    }
}
