package sn.ias.Kspace.service;

import sn.ias.Kspace.entities.Publication;

import java.util.Set;

public interface PublicationService {

    public Publication addPublication(Publication publication);

    public Publication updatePublication(Publication publication);

    public Set<Publication> getPublications();

    public Publication getPublication(Long id);

    public void deletePublication(Long id);
}
