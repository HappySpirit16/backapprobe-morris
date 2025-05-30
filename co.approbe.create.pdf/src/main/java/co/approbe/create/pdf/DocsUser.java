package co.approbe.create.pdf;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="docsUser")
public class DocsUser {
	
	
		@DynamoDBHashKey
		private String numberId;
		@DynamoDBAttribute
		private byte[] authorizationAward;
		@DynamoDBAttribute
		private byte[] authorizationBorrower;
		@DynamoDBAttribute
		private byte[] contractAwardFirstHalf;
		@DynamoDBAttribute
		private byte[] contractAwardSecondHalf;
		@DynamoDBAttribute
		private byte[] mutualContractFirstHalf;
		@DynamoDBAttribute
		private byte[] mutualContractSecondHalf;
		@DynamoDBAttribute
		private byte[] mutualContractFirstHalf1;
		@DynamoDBAttribute
		private byte[] mutualContractSecondHalf1;
		@DynamoDBAttribute
		private byte[] mutualContractFirstHalf2;
		@DynamoDBAttribute
		private byte[] mutualContractSecondHalf2;
		@DynamoDBAttribute
		private byte[] power;
		 @DynamoDBAttribute(attributeName = "promissory")
		private byte[] promissory;
		
		LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		@DynamoDBAttribute
		private String dateSave = dateTime.format(dtformat);
		
		
		public String getNumberId() {
			return numberId;
		}


		public void setNumberId(String numberId) {
			this.numberId = numberId;
		}


		public byte[] getAuthorizationAward() {
			return authorizationAward;
		}


		public void setAuthorizationAward(byte[] authorizationAward) {
			this.authorizationAward = authorizationAward;
		}


		public byte[] getAuthorizationBorrower() {
			return authorizationBorrower;
		}


		public void setAuthorizationBorrower(byte[] authorizationBorrower) {
			this.authorizationBorrower = authorizationBorrower;
		}

		public byte[] getPower() {
			return power;
		}


		public void setPower(byte[] power) {
			this.power = power;
		}


		public byte[] getPromissory() {
			return promissory;
		}


		public void setPromissory(byte[] promissory) {
			this.promissory = promissory;
		}


		public String getDateSave() {
			return dateSave;
		}


		public void setDateSave(String dateSave) {
			this.dateSave = dateSave;
		}

		

		public byte[] getContractAwardFirstHalf() {
			return contractAwardFirstHalf;
		}


		public void setContractAwardFirstHalf(byte[] contractAwardFirstHalf) {
			this.contractAwardFirstHalf = contractAwardFirstHalf;
		}


		public byte[] getContractAwardSecondHalf() {
			return contractAwardSecondHalf;
		}


		public void setContractAwardSecondHalf(byte[] contractAwardSecondHalf) {
			this.contractAwardSecondHalf = contractAwardSecondHalf;
		}


		public byte[] getMutualContractFirstHalf() {
			return mutualContractFirstHalf;
		}


		public void setMutualContractFirstHalf(byte[] mutualContractFirstHalf) {
			this.mutualContractFirstHalf = mutualContractFirstHalf;
		}


		public byte[] getMutualContractSecondHalf() {
			return mutualContractSecondHalf;
		}


		public void setMutualContractSecondHalf(byte[] mutualContractSecondHalf) {
			this.mutualContractSecondHalf = mutualContractSecondHalf;
		}


		public DocsUser() {
			super();
		}


		public byte[] getMutualContractFirstHalf1() {
			return mutualContractFirstHalf1;
		}


		public void setMutualContractFirstHalf1(byte[] mutualContractFirstHalf1) {
			this.mutualContractFirstHalf1 = mutualContractFirstHalf1;
		}


		public byte[] getMutualContractSecondHalf1() {
			return mutualContractSecondHalf1;
		}


		public void setMutualContractSecondHalf1(byte[] mutualContractSecondHalf1) {
			this.mutualContractSecondHalf1 = mutualContractSecondHalf1;
		}


		public byte[] getMutualContractFirstHalf2() {
			return mutualContractFirstHalf2;
		}


		public void setMutualContractFirstHalf2(byte[] mutualContractFirstHalf2) {
			this.mutualContractFirstHalf2 = mutualContractFirstHalf2;
		}


		public byte[] getMutualContractSecondHalf2() {
			return mutualContractSecondHalf2;
		}


		public void setMutualContractSecondHalf2(byte[] mutualContractSecondHalf2) {
			this.mutualContractSecondHalf2 = mutualContractSecondHalf2;
		}






		

		
}
