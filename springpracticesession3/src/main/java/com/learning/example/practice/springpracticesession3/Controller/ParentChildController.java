package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice.ChildrenDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice.ParentDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice.ParentPKDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice.ChildrenEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice.ParentEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice.ParentPKEntity;
import com.learning.example.practice.springpracticesession3.Repository.onetomanypractice.ParentChildRelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/relationShip")
@RequiredArgsConstructor
public class ParentChildController {

      private final ParentChildRelationshipRepository relationshipRepository;

      @PostMapping(path = "/createRelation")
      public ResponseEntity<ParentDTO> createNewRelationShip(@RequestBody ParentDTO parentDTO)
      {
          List<ChildrenDTO> childrenDTO = parentDTO.getChildrenDTO();

          List<ChildrenEntity> collect = childrenDTO.stream().map(childrenEnt -> {
              ChildrenEntity childrenEntity = new ChildrenEntity();
              childrenEntity.setName(childrenEnt.getName());
              childrenEntity.setNumberOfChildren(childrenEnt.getNumberOfChildren());
              return childrenEntity;
          }).collect(Collectors.toList());


          ParentPKEntity parentPKEntity = new ParentPKEntity();
          parentPKEntity.setId(parentDTO.getParentPKDTO().getId());
          parentPKEntity.setName(parentDTO.getParentPKDTO().getName());


          ParentEntity parentEntity = new ParentEntity();
          parentEntity.setParentPKEntity(parentPKEntity);
          parentEntity.setMobileNumber(parentDTO.getMobileNumber());
          parentEntity.setAddress(parentDTO.getAddress());

          //bi directional
          List<ChildrenEntity> collect2 = collect.stream().map(childrenentity -> {
              ChildrenEntity childrenEntity = new ChildrenEntity();
              childrenentity.setParentEntity(parentEntity);
              return childrenentity;
          }).collect(Collectors.toList());

          parentEntity.setChildrenEntity(collect2);

          ParentEntity save = relationshipRepository.save(parentEntity);


          List<ChildrenEntity> childrenEntity = save.getChildrenEntity();
          List<ChildrenDTO> collect1 = childrenEntity.stream().map(childrenEntities -> {
              ChildrenDTO childrenDTO1 = new ChildrenDTO(childrenEntities.getName(), childrenEntities.getNumberOfChildren());
              return childrenDTO1;
          }).collect(Collectors.toList());

          ParentPKDTO parentPKDTO = new ParentPKDTO(save.getParentPKEntity().getId(),save.getParentPKEntity().getName());

          ParentDTO parentDTO1 = new ParentDTO(
                  save.getMobileNumber(), save.getAddress(),parentPKDTO,collect1);

          return ResponseEntity.ok().body(parentDTO1);
      }

      @GetMapping("/fetchRelationDetails/{id}")
      public ResponseEntity<ParentDTO> fetchParentDetails(@PathVariable Integer id)
      {
          ParentEntity parentEntity = relationshipRepository.findById(id).get();
          List<ChildrenEntity> childrenEntity = parentEntity.getChildrenEntity();
          List<ChildrenDTO> collect = childrenEntity.stream().map(childrenEntities -> {
              ChildrenDTO childrenDTO = new ChildrenDTO(childrenEntities.getName(), childrenEntities.getNumberOfChildren());
              return childrenDTO;
          }).collect(Collectors.toList());

          ParentPKDTO parentPKDTO = new ParentPKDTO(parentEntity.getParentPKEntity().getId(),parentEntity.getParentPKEntity().getName());

          ParentDTO parentDTO = new ParentDTO(
                  parentEntity.getMobileNumber(), parentEntity.getAddress(),parentPKDTO, collect);

          return ResponseEntity.ok().body(parentDTO);
      }
}
