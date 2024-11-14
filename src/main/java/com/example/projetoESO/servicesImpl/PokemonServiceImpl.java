package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.dto.PokemonDTO;
import com.example.projetoESO.dto.UserPokemonDTO;
import com.example.projetoESO.entities.Color;
import com.example.projetoESO.entities.Habitat;
import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.entities.Types;
import com.example.projetoESO.form.PokemonFilterForm;
import com.example.projetoESO.repositories.PokemonRepository;
import com.example.projetoESO.services.PokemonService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PokemonDTO> getAllPokemons(int page, int size) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pokemon> cq = cb.createQuery(Pokemon.class);
        Root<Pokemon> pokemon = cq.from(Pokemon.class);
        List<Predicate> predicates = new ArrayList<>();
        List<PokemonDTO> pokemonsListResponse = new ArrayList<>();
        cq.select(pokemon).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Pokemon> query = entityManager.createQuery(cq);
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        query.getResultList().stream().forEach(pokemonCurrent -> {
            pokemonsListResponse.add(convertEntityToDto(pokemonCurrent));
        });

        return pokemonsListResponse;
    }

    private PokemonDTO convertEntityToDto(Pokemon pokemonEntity) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemonEntity.getId());
        pokemonDTO.setTypes(pokemonEntity.getTypes());
        if(pokemonEntity.getUser() != null) {
            pokemonDTO.setUser(new UserPokemonDTO(pokemonEntity.getUser().getId(), pokemonEntity.getUser().getName()));
        }
        pokemonDTO.setName(pokemonEntity.getName());
        pokemonDTO.setWeight(pokemonEntity.getWeight());
        pokemonDTO.setUrlStatus(pokemonEntity.getUrlStatus());
        pokemonDTO.setFront_default(pokemonEntity.getFront_default());
        pokemonDTO.setColors(pokemonEntity.getColors());
        pokemonDTO.setHabitat(pokemonEntity.getHabitat());
        pokemonDTO.setBase_experience(pokemonEntity.getBase_experience());
        return pokemonDTO;
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        return pokemonRepository.findByName(name);
    }

    public void updatePokemon(Pokemon pokemonEntityUpdate) {
        if (pokemonRepository.existsById(pokemonEntityUpdate.getId())) {
            pokemonRepository.save(pokemonEntityUpdate);
        }
    }

    @Override
    public List<PokemonDTO> filterPokemons(PokemonFilterForm pokemonFilterForm) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pokemon> cq = cb.createQuery(Pokemon.class);
        Boolean filterApply = false;
        Root<Pokemon> pokemon = cq.from(Pokemon.class);
        Join<Pokemon, Habitat> habitat = pokemon.join("habitat");
        Join<Pokemon, Color> color = pokemon.join("colors");
        Join<Pokemon, Types> type = pokemon.join("types");
        List<PokemonDTO> pokemonsListResponse = new ArrayList<>();
        List<Predicate> predicates = new ArrayList<>();
        if (pokemonFilterForm.getName() != null && !pokemonFilterForm.getName().isEmpty()) {
            predicates.add(cb.like(pokemon.get("name"), "%" + pokemonFilterForm.getName() + "%"));
            filterApply = true;
        }
        if (pokemonFilterForm.getType() != null && !pokemonFilterForm.getType().isEmpty()) {
            predicates.add(cb.equal(type.get("name"), pokemonFilterForm.getType()));
            filterApply = true;
        }
        if (pokemonFilterForm.getColor() != null && !pokemonFilterForm.getColor().isEmpty()) {
            predicates.add(cb.equal(color.get("name"), pokemonFilterForm.getColor()));
            filterApply = true;
        }
        if (pokemonFilterForm.getHabitat() != null && !pokemonFilterForm.getHabitat().isEmpty()) {
            predicates.add(cb.equal(habitat.get("name"), pokemonFilterForm.getHabitat()));
            filterApply = true;
        }
        if (pokemonFilterForm.getMinWeight() != 0) {
            predicates.add(cb.greaterThanOrEqualTo(pokemon.get("weight"), pokemonFilterForm.getMinWeight()));
            filterApply = true;
        }
        if (pokemonFilterForm.getMaxWeight() != 0) {
            predicates.add(cb.lessThanOrEqualTo(pokemon.get("weight"), pokemonFilterForm.getMaxWeight()));
            filterApply = true;
        }
        if (pokemonFilterForm.getMinBaseExperience() != 0) {
            predicates.add(cb.greaterThanOrEqualTo(pokemon.get("base_experience"), pokemonFilterForm.getMinBaseExperience()));
            filterApply = true;
        }
        if (pokemonFilterForm.getMaxBaseExperience() != 0) {
            predicates.add(cb.lessThanOrEqualTo(pokemon.get("base_experience"), pokemonFilterForm.getMaxBaseExperience()));
            filterApply = true;
        }

        cq.select(pokemon).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Pokemon> query = entityManager.createQuery(cq);
        query.setFirstResult(pokemonFilterForm.getPage() * pokemonFilterForm.getSize());
        query.setMaxResults(pokemonFilterForm.getSize());
        if(filterApply) {
            List<PokemonDTO> finalPokemonsListResponse = pokemonsListResponse;
            query.getResultList().stream().forEach(pokemonCurrent -> {
                finalPokemonsListResponse.add(convertEntityToDto(pokemonCurrent));
            });
        } else {
            pokemonsListResponse = this.getAllPokemons(0, 10);
        }

        return pokemonsListResponse;
    }

}
