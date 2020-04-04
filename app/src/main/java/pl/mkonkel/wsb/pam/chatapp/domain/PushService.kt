package pl.mkonkel.wsb.pam.chatapp.domain

import com.google.firebase.iid.FirebaseInstanceId
import pl.mkonkel.wsb.pam.chatapp.repository.LoggedInRepository
import timber.log.Timber

class PushService(private val repository: LoggedInRepository) {
    fun initialize() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.e("getInstanceId failed ${task.exception}")
                }


                task.result?.token?.let {
                    Timber.v("FCM Token: $it")

                }
            }
    }
}