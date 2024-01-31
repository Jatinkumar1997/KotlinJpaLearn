package com.example.kotlinjpalearn.task1.htmlDsl

class HtmlTag private constructor(
    private val name: String,
    private val attributes: Map<String, String>,
    private val children: List<HtmlElement>,
) : HtmlElement {

    override fun render(): String {
        val attributeString = attributes.entries.joinToString(separator = " ") { (key, value) ->
            "$key=\"$value\""
        }
        return if (children.isEmpty()) {
            "<$name $attributeString/>"
        } else {
            val childrenString = children.joinToString("\n") {
                it.render()
            }
            """
                |<$name $attributeString>
                |$childrenString
                |</$name>
            """.trimMargin()
        }
    }

    class Builder(
        var name: String,
        var attributes: Map<String, String> = emptyMap(),
        var children: List<HtmlElement> = emptyList(),
    ) {

        fun build() = HtmlTag(name, attributes, children)

    }

}