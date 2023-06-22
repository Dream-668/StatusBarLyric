package statusbar.lyric.activity.page

import android.annotation.SuppressLint
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.dialog.MIUIDialog
import cn.fkj233.ui.dialog.NewDialog
import statusbar.lyric.R
import statusbar.lyric.config.ActivityOwnSP
import statusbar.lyric.tools.ActivityTestTools
import statusbar.lyric.tools.ActivityTools
import statusbar.lyric.tools.Tools
import statusbar.lyric.tools.Tools.dispose
import java.text.SimpleDateFormat
import java.util.Locale


@SuppressLint("NonConstantResourceId")
@BMPage
class TestModePage : BasePage() {
    override fun onCreate() {
        TextSSw(textId = R.string.TestMode, key = "testMode")
        TextSA(textId = R.string.TimeFormat, onClickListener = {
            NewDialog(activity) {
                setTitle(getString(R.string.TimeFormat))
                setEditText(ActivityOwnSP.config.timeFormat, "H:mm")
                Button(getString(R.string.UnderstandTimeFormat)) { ActivityTools.openUrl("https://zhuanlan.zhihu.com/p/51695220") }
                Button(getString(R.string.OK)) {
                    ActivityOwnSP.config.timeFormat = getEditText()
                    val currentTime = System.currentTimeMillis()
                    val dateFormat = SimpleDateFormat(ActivityOwnSP.config.timeFormat, Locale.getDefault())
                    val nowTime = dateFormat.format(currentTime).dispose()
                    ActivityTools.showToastOnLooper(getString(R.string.PrintTimeFormat).format(getEditText(), nowTime))
                }
                Button(getString(R.string.Cancel), cancelStyle = true)
                Finally { dismiss() }
            }.show()
        })
        TextSA(textId = R.string.GetHook, onClickListener = {
            ActivityTestTools.getClass()
        })
        Line()
        TextSA(textId = R.string.ResetSystemUi, onClickListener = {
            MIUIDialog(activity) {
                setTitle(R.string.ResetSystemUi)
                setMessage(R.string.RestartUITips)
                setLButton(R.string.OK) {
                    Tools.shell("pkill -f com.android.systemui", true)
                    dismiss()
                }
                setRButton(R.string.Cancel) { dismiss() }
            }.show()
        })
    }
}