package id.Panji.Assesment2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.Panji.Assesment2.database.NominalDao
import id.Panji.Assesment2.model.Nominal
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: NominalDao) : ViewModel() {

    val data: StateFlow<List<Nominal>> = dao.getNominal().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}
