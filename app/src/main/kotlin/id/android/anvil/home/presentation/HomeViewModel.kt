package id.android.anvil.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.android.anvil.home.domain.HomeParams
import id.android.anvil.home.domain.HomeUsecase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val usecase: HomeUsecase) : ViewModel(), HomeView {

  private val disposables = CompositeDisposable()
  private val observer = MutableLiveData<HomeViewState>()

  override val states: LiveData<HomeViewState>
    get() = observer

  override fun onCleared() {
    disposables.clear()

    super.onCleared()
  }

  override fun fetchHome(params: HomeParams) {
    usecase.fetchHome(params)
      .map<HomeViewState>(HomeViewState::Success)
      .onErrorReturn(HomeViewState::Error)
      .toFlowable()
      .startWithItem(HomeViewState.Loading)
      .subscribe(observer::postValue)
      .let(disposables::add)
  }
}