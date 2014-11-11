package crm.to;

public class TransSub {

		
	
		@Override
		public String toString() {
		return "TransSub [content_id=" + content_id + ", cost=" + cost
				+ ", quantity=" + quantity + ", transaction_id="
				+ transaction_id + ", provider_id=" + provider_id
				+ ", prevalloc=" + prevalloc + ", newalloc=" + newalloc
				+ ", submitted=" + submitted + ", rate=" + rate + ", plate_id="
				+ plate_id + "]";
	}
		
		private int content_id;
		private float cost;
		private int quantity;
		private int transaction_id;
		private int provider_id;
		public int getProvider_id() {
			return provider_id;
		}
		public void setProvider_id(int provider_id) {
			this.provider_id = provider_id;
		}
		private int prevalloc;
		private int newalloc;
		private int submitted;
		
		
		public int getSubmitted() {
			return submitted;
		}
		public void setSubmitted(int submitted) {
			this.submitted = submitted;
		}
		private float rate;
		private int plate_id;
		
		public int getPlate_id() {
			return plate_id;
		}
		public void setPlate_id(int plate_id) {
			this.plate_id = plate_id;
		}
		public int getPrevalloc() {
			return prevalloc;
		}
		public void setPrevalloc(int prevalloc) {
			this.prevalloc = prevalloc;
		}
		public int getNewalloc() {
			return newalloc;
		}
		public void setNewalloc(int newalloc) {
			this.newalloc = newalloc;
		}
		public float getRate() {
			return rate;
		}
		public void setRate(float rate) {
			this.rate = rate;
		}
		public int getContent_id() {
			return content_id;
		}
		public void setContent_id(int content_id) {
			this.content_id = content_id;
		}
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getTransaction_id() {
			return transaction_id;
		}
		public void setTransaction_id(int transaction_id) {
			this.transaction_id = transaction_id;
		}
		
}
