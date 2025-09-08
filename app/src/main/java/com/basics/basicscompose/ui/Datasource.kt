package com.basics.basicscompose.ui

data class Topic(val title: String, val description: String)

fun sampleItems(): List<Topic> {
    return listOf(
        Topic("Text y TextField", "Mostrar textos y recibir entrada del usuario"),
        Topic("Layouts (Row/Column/Box)", "Organizar elementos en la pantalla"),
        Topic("State", "Uso de remember y mutableStateOf para estado local"),
        Topic("LazyColumn", "Listas eficientes y componibles"),
        Topic("MaterialTheme", "Uso de estilos y colores con Material3")
    )
}
