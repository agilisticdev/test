package com.mkyong.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mkyong.transaction.Payment;
import com.mkyong.transaction.TransactionDao;


@Component
@Path("/payment")
public class PaymentResource {

  @Inject
  TransactionDao transactionDao;


  @POST
  @Path("/pay")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response pay(Payment payment) {
    transactionDao.setPayment(payment);
    payment.setProcessed(true);
    return Response.ok(payment).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getResults(@QueryParam("id") int articleId) {
    return Response.ok(transactionDao.getPayment(articleId)).build();
  }

}
