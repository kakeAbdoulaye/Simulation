package com.evenement;

import java.util.List;

import com.model.Client;
import com.model.Echeancier;
import com.model.TypeEvtTraite;

public class ArriveeClient extends Evenement {
	
	
	
	public Evenement evenement;
	private List<Client>clients;
	public ArriveeClient(TypeEvtTraite evt,Evenement event, List<Client>clients)
	{
		typeEvt=evt;
		evenement=event;
		this.clients=clients;
	}
	public   void executer(float sh)
	{
		evenement.setHs(sh);
		Client nouveau=new Client();
		nouveau.setDateArrivee(evenement.getHs());
		clients.add(nouveau);
		AccesFileAttente acces=new AccesFileAttente(TypeEvtTraite.AccFA,evenement,clients);
		acces.setHs(evenement.getHs());
		acces.setHeureDebut(evenement.getHs());
		acces.setB(evenement.getB());
		acces.setQ(evenement.getQ());
		acces.setAttenteGlobale(evenement.getAttenteGlobale());
		acces.setTotalClientNumber(evenement.getTotalClientNumber());
		acces.setTempMoyenAttente(evenement.getTempMoyenAttente());
		acces.setDureeService(evenement.getDureeService());
		acces.setInterArrivee(evenement.getInterArrivee());
		Echeancier.add(acces);
		evenement.setTotalClientNumber(evenement.getTotalClientNumber()+1);
		ArriveeClient arr= new ArriveeClient(TypeEvtTraite.ArrCl,evenement,clients); 
		arr.setHs(evenement.getHs());
		arr.setHeureDebut(evenement.getHs()+evenement.getInterArrivee());
		arr.setB(evenement.getB());
		arr.setQ(evenement.getQ());
		arr.setAttenteGlobale(evenement.getAttenteGlobale());
		arr.setTotalClientNumber(evenement.getTotalClientNumber());
		arr.setTempMoyenAttente(evenement.getTempMoyenAttente());
		arr.setDureeService(evenement.getDureeService());
		arr.setInterArrivee(evenement.getInterArrivee());
		Echeancier.add(arr);
		
	}

}
