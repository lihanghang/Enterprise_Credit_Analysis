/**
 * 
 */
package com.ccip.bank.bean;
/**
 * @date 2018年4月5日 下午5:13:58 
 */
/**
 * @author Mason
 *科研投入推荐模型javaBean 接受前台参数
 */
public class creditQualityBean {
	
	private double debt_rate;
	private double interest;
	private double inventoryTurn;
	private double flowDebt;
	private double cost;
	private double ownerEquity;
	/**
	 * @return the debt_rate
	 */
	public double getDebt_rate() {
		return debt_rate;
	}
	/**
	 * @param debt_rate the debt_rate to set
	 */
	public void setDebt_rate(double debt_rate) {
		this.debt_rate = debt_rate;
	}
	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	/**
	 * @return the inventoryTurn
	 */
	public double getInventoryTurn() {
		return inventoryTurn;
	}
	/**
	 * @param inventoryTurn the inventoryTurn to set
	 */
	public void setInventoryTurn(double inventoryTurn) {
		this.inventoryTurn = inventoryTurn;
	}
	/**
	 * @return the flowDebt
	 */
	public double getFlowDebt() {
		return flowDebt;
	}
	/**
	 * @param flowDebt the flowDebt to set
	 */
	public void setFlowDebt(double flowDebt) {
		this.flowDebt = flowDebt;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the ownerEquity
	 */
	public double getOwnerEquity() {
		return ownerEquity;
	}
	/**
	 * @param ownerEquity the ownerEquity to set
	 */
	public void setOwnerEquity(double ownerEquity) {
		this.ownerEquity = ownerEquity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "creditQualityBean [debt_rate=" + debt_rate + ", interest="
				+ interest + ", inventoryTurn=" + inventoryTurn + ", flowDebt="
				+ flowDebt + ", cost=" + cost + ", ownerEquity=" + ownerEquity
				+ "]";
	}
	
	
	
}

