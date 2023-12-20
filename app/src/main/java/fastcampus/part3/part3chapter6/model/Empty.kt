package fastcampus.part3.part3chapter6.model

class Empty : ListItem{
    override val viewType: ViewType
        get() = ViewType.EMPTY
}