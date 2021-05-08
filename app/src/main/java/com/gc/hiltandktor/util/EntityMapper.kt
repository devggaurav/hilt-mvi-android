package com.gc.hiltandktor.util

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

interface EntityMapper<Entity,DomainModel> {

     fun mapFromEntity(entity: Entity): DomainModel

      fun mapToEntity(domainModel: DomainModel) : Entity

}