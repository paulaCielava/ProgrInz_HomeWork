package lv.venta.service;

import java.util.ArrayList;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;

public interface ITicketCRUDService {

	ArrayList<Ticket> selectAllChildTickets(boolean isChild);

	ArrayList<Trip> selectAllTicketsByTripId(long idticket) throws Exception;

}
