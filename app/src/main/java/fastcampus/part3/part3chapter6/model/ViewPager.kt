package fastcampus.part3.part3chapter6.model

import fastcampus.part3.part3chapter6.model.ListItem
import fastcampus.part3.part3chapter6.model.ViewType

data class ViewPager(
    val items : List<ListItem>
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.VIEW_PAGER
}
