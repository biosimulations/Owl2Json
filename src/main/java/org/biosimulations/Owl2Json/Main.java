package org.biosimulations.Owl2Json;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import no.s11.owlapijsonld.JsonLdOntologyFormat;
import no.s11.owlapijsonld.JsonLdStorer;

import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors

public class Main {
    public static void main(String[] args) throws OWLOntologyStorageException, OWLOntologyCreationException {
        String owlURL = args[0];
        String filePath = args[1];

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        JsonLdStorer.register(manager);

        OWLOntology ontology = manager.loadOntology(IRI.create(owlURL));

        File outPut = new File(filePath);

        manager.saveOntology(ontology, new JsonLdOntologyFormat(), IRI.create(outPut));
    }
}
