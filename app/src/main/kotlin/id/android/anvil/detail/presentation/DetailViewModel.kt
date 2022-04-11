package id.android.anvil.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.android.anvil.detail.domain.DetailEntity
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel(), DetailView {

  private val observer = MutableLiveData<DetailViewState>()

  override val states: LiveData<DetailViewState>
    get() = observer

  override fun loadDetail(entity: DetailEntity) {
    observer.postValue(DetailViewState.Success(entity))
  }
}