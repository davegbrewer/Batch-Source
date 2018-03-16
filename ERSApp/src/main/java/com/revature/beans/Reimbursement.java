package com.revature.beans;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimbursementId;
	private BigDecimal amount;
	private String decription;
	private InputStream receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int authorId;
	private String authorName;
	private int resolverId;
	private String resolverName;
	private String type;
	private String status;

	public Reimbursement() {

	}

	public Reimbursement(int reimbursementId, BigDecimal amount, String decription, InputStream receipt,
			Timestamp submitted, Timestamp resolved, int authorId, String authorName, int resolverId,
			String resolverName, String type, String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.decription = decription;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.authorName = authorName;
		this.resolverId = resolverId;
		this.resolverName = resolverName;
		this.type = type;
		this.status = status;
	}

	public Reimbursement(int reimbursementId, BigDecimal amount, String decription, InputStream receipt,
			Timestamp submitted, Timestamp resolved, int authorId, int resolverId, String resolverName, String type,
			String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.decription = decription;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.resolverName = resolverName;
		this.type = type;
		this.status = status;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public InputStream getRecipt() {
		return receipt;
	}

	public void setRecipt(InputStream receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolverName() {
		return resolverName;
	}

	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}

	public InputStream getReceipt() {
		return receipt;
	}

	public void setReceipt(InputStream receipt) {
		this.receipt = receipt;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", decription=" + decription
				+ ", receipt=" + receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId="
				+ authorId + ", authorName=" + authorName + ", resolverId=" + resolverId + ", resolverName="
				+ resolverName + ", type=" + type + ", status=" + status + "]";
	}

}
