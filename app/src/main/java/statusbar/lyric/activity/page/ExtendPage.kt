package statusbar.lyric.activity.page

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import statusbar.lyric.R
import statusbar.lyric.tools.ActivityTools.changeConfig

@BMPage
class ExtendPage : BasePage() {
    override fun onCreate() {
        TextSw(textId = R.string.HideNotificationIcon, key = "hideNotificationIcon", onClickListener = { changeConfig() })
        TextSSw(textId = R.string.LimitVisibilityChange, tipsId = R.string.LimitVisibilityChangeTips, key = "limitVisibilityChange", onClickListener = { changeConfig() })
        TextSw(textId = R.string.HideLyricWhenLockScreen, key = "hideLyricWhenLockScreen", onClickListener = { changeConfig() })
    }
}