package id.android.anvil.detail.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import id.android.anvil.R
import id.android.anvil.databinding.ItemDetailContentBinding
import id.android.anvil.databinding.ItemDetailTitleBinding
import id.android.anvil.detail.domain.DetailEntity

enum class DetailAdapterType {
  TITLE,
  CONTENT
}

class DetailAdapter(private val entity: DetailEntity) : Adapter<ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    when (viewType) {
      DetailAdapterType.TITLE.ordinal -> {
        DetailTitleViewHolder(
          ItemDetailTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
          )
        )
      }
      DetailAdapterType.CONTENT.ordinal -> {
        DetailContentViewHolder(
          ItemDetailContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
          )
        )
      }
      else -> throw RuntimeException("Illegal view type")
    }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    when (holder) {
      is DetailTitleViewHolder -> holder.bindTitleView(entity)
      is DetailContentViewHolder -> holder.bindContentView(entity)
    }
  }

  override fun getItemCount() = DetailAdapterType.values().count()

  override fun getItemViewType(position: Int) =
    when (position) {
      0 -> DetailAdapterType.TITLE.ordinal
      else -> DetailAdapterType.CONTENT.ordinal
    }

  inner class DetailTitleViewHolder(private val binding: ItemDetailTitleBinding) : ViewHolder(binding.root) {

    fun bindTitleView(entity: DetailEntity) {
      with(binding) {
        ivDetail.load(entity.background)
      }
    }
  }

  inner class DetailContentViewHolder(private val binding: ItemDetailContentBinding) : ViewHolder(binding.root) {

    fun bindContentView(entity: DetailEntity) {
      with(binding) {
        tvContent.text = entity.content
        tvRating.text = binding.root.context.getString(R.string.rating, entity.rating.toString())
      }
    }
  }
}