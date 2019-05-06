package com.ccip.bank.bean;

/**
 * @date 2018年5月2日 上午10:16:27 
 */
/**
 * @author Mason
 *
 */
public class financialRiskBean {

	private double flowAssertRate;
	private double checkRate;
	private int creditGrade;
	private double financialCostRate;
	private double equityRatio;
	private double flowPercent;
	private double debtRate;
	private double interest;
	private double cashFlow;
	private double growthRateOperateIncome;
	private double allAsserrtIncrease;

	/**
	 * @return the flowAssertRate
	 */
	public double getFlowAssertRate() {
		return flowAssertRate;
	}

	/**
	 * @param flowAssertRate
	 *            the flowAssertRate to set
	 */
	public void setFlowAssertRate(double flowAssertRate) {
		this.flowAssertRate = flowAssertRate;
	}

	/**
	 * @return the checkRate
	 */
	public double getCheckRate() {
		return checkRate;
	}

	/**
	 * @param checkRate
	 *            the checkRate to set
	 */
	public void setCheckRate(double checkRate) {
		this.checkRate = checkRate;
	}

	/**
	 * @return the creditGrade
	 */
	public int getCreditGrade() {
		return creditGrade;
	}

	/**
	 * @param creditGrade
	 *            the creditGrade to set
	 */
	public void setCreditGrade(int creditGrade) {
		this.creditGrade = creditGrade;
	}

	/**
	 * @return the financialCostRate
	 */
	public double getFinancialCostRate() {
		return financialCostRate;
	}

	/**
	 * @param financialCostRate
	 *            the financialCostRate to set
	 */
	public void setFinancialCostRate(double financialCostRate) {
		this.financialCostRate = financialCostRate;
	}

	/**
	 * @return the equityRatio
	 */
	public double getEquityRatio() {
		return equityRatio;
	}

	/**
	 * @param equityRatio
	 *            the equityRatio to set
	 */
	public void setEquityRatio(double equityRatio) {
		this.equityRatio = equityRatio;
	}

	/**
	 * @return the flowPercent
	 */
	public double getFlowPercent() {
		return flowPercent;
	}

	/**
	 * @param flowPercent
	 *            the flowPercent to set
	 */
	public void setFlowPercent(double flowPercent) {
		this.flowPercent = flowPercent;
	}

	/**
	 * @return the debtRate
	 */
	public double getDebtRate() {
		return debtRate;
	}

	/**
	 * @param debtRate
	 *            the debtRate to set
	 */
	public void setDebtRate(double debtRate) {
		this.debtRate = debtRate;
	}

	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * @param interest
	 *            the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	/**
	 * @return the cashFlow
	 */
	public double getCashFlow() {
		return cashFlow;
	}

	/**
	 * @param cashFlow
	 *            the cashFlow to set
	 */
	public void setCashFlow(double cashFlow) {
		this.cashFlow = cashFlow;
	}

	/**
	 * @return the growthRateOperateIncome
	 */
	public double getGrowthRateOperateIncome() {
		return growthRateOperateIncome;
	}

	/**
	 * @param growthRateOperateIncome
	 *            the growthRateOperateIncome to set
	 */
	public void setGrowthRateOperateIncome(double growthRateOperateIncome) {
		this.growthRateOperateIncome = growthRateOperateIncome;
	}

	/**
	 * @return the allAsserrtIncrease
	 */
	public double getAllAsserrtIncrease() {
		return allAsserrtIncrease;
	}

	/**
	 * @param allAsserrtIncrease
	 *            the allAsserrtIncrease to set
	 */
	public void setAllAsserrtIncrease(double allAsserrtIncrease) {
		this.allAsserrtIncrease = allAsserrtIncrease;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "financialRiskBean [flowAssertRate=" + flowAssertRate
				+ ", checkRate=" + checkRate + ", creditGrade=" + creditGrade
				+ ", financialCostRate=" + financialCostRate + ", equityRatio="
				+ equityRatio + ", flowPercent=" + flowPercent + ", debtRate="
				+ debtRate + ", interest=" + interest + ", cashFlow="
				+ cashFlow + ", GrowthRateOperateIncome="
				+ growthRateOperateIncome + ", allAsserrtIncrease="
				+ allAsserrtIncrease + "]";
	}

}
