package id.android.anvil.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import id.android.anvil.databinding.ItemHomeBinding
import id.android.anvil.home.domain.HomeEntity.Result
import id.android.anvil.home.presentation.HomeAdapter.HomeViewHolder

class HomeAdapter(private val results: List<Result>) : Adapter<HomeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    HomeViewHolder(
      ItemHomeBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.bindView(results[holder.adapterPosition])
  }

  override fun getItemCount() = results.count()

  inner class HomeViewHolder(private val binding: ItemHomeBinding) : ViewHolder(binding.root) {

    fun bindView(result: Result) {
      with(binding) {
        ivHome.load(result.image)
        tvTitle.text = result.title
        tvRating.text = "${result.rating}"
      }
    }
  }
}