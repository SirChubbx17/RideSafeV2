package com.example.ridesafev2

class HistoryAdapter(private var historyList: List<HistoryData>) {
}

//class FAQAdapter(private var faqList: List<FAQData>) :
//    RecyclerView.Adapter<FAQAdapter.FAQViewHolder>(){
//
//    inner class FAQViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        var questionTxt : TextView = itemView.findViewById(R.id.faq)
//        var contentTxt : TextView = itemView.findViewById(R.id.faq_content)
//        var constraintLayout : ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
//
//        fun collapseExpandedView(){
//            contentTxt.visibility = View.GONE
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.rs_frag_faqrow, parent, false)
//        return FAQViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) {
//        val faqData = faqList[position]
//        holder.questionTxt.text = faqData.question
//        holder.contentTxt.text = faqData.content
//
//        val isExpandable: Boolean = faqData.isExpandable
//        holder.contentTxt.visibility = if (isExpandable) View.VISIBLE else View.GONE
//
//        holder.constraintLayout.setOnClickListener {
//            isAnyItemExpanded(position)
//            faqData.isExpandable = !faqData.isExpandable
//            notifyItemChanged(position, Unit)
//        }
//    }
//
//    private fun isAnyItemExpanded(position: Int) {
//        val temp = faqList.indexOfFirst {
//            it.isExpandable
//        }
//        if (temp >=0 && temp != position){
//            faqList[temp].isExpandable = false
//            notifyItemChanged(temp, 0)
//        }
//    }
//
//    override fun onBindViewHolder(
//        holder: FAQViewHolder,
//        position: Int,
//        payloads: MutableList<Any>
//    ) {
//        if(payloads.isNotEmpty() && payloads[0] == 0){
//            holder.collapseExpandedView()
//        }else{
//            super.onBindViewHolder(holder, position, payloads)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return faqList.size
//    }
//}