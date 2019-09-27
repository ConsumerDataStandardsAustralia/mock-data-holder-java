/**
 * This package contains all the non-domain specific stuff.
 * Annotations, enums, etc in this package are used to specify meta info of domain specific models.
 * E.g, they can specify an endpoint, endpoint's authentication method, data format, etc.
 *
 * They are not intrinsic to domain models, which means they can be replaced. E.g, Swagger's annotations
 * such as @ApiResponse, @ApiOperation and Spring framework's @RequestMapping together can replace {@code @EndPoint}
 *
 * The stuff in this package are the interfaces between codegen and api-model.
 * codegen get domain models' meta info by reflecting on these annotations, enums, etc, combined with other
 * meta info intrinsic in domain models themselves, such as type, name, etc, to construct a complete picture of
 * the domain model.
 */
package au.org.consumerdatastandards.support;