 package com.paydock.javasdk.Models;

 import java.math.BigDecimal;

 public class ChargeRequestStripe extends ChargeRequestBase
 {
     public MetaData meta;
     private static class MetaData
     {
         public String stripe_direct_account_id;
         public String stripe_destination_account_id;
         public String stripe_transfer_group;
         public Transfer[] stripe_transfer = new Transfer[]{};
     }
     private static class Transfer
     {
         public BigDecimal amount;
         public String currency;
         public String destination;
     }
 }
