import HandsOn from './components/HandsOn/HandsOn'
import ImageCustom from './components/ImageCustom/ImageCustom'
import Text from './components/Text/Text'
import ThemeToggler from './components/ThemeToggler/ThemeToggler'
import AppPage from './components/Page/AppPage'
import Products from './components/Products/Products'
import { withComponentMappingContext, MapTo } from '@mavice/aem-vue-editable-components'

// HandsOn Component Mapping
MapTo('wknd-spa-vue/components/hands-on')(
  HandsOn,
  {
    emptyLabel: 'HandsOn',
    isEmpty: (props) => {
      return !props || !props.src || props.src.trim().length < 1
    },
    resourceType: 'wknd-spa-vue/components/hands-on'
  }
)

// ImageCustom Component Mapping
MapTo('wknd-spa-vue/components/image-custom')(
  ImageCustom,
  {
    emptyLabel: 'Image',
    isEmpty: (props) => {
      return !props || !props.src || props.src.trim().length < 1
    },
    resourceType: 'wknd-spa-vue/components/image-custom'
  }
)

// Text Component Mapping
MapTo('wknd-spa-vue/components/text')(
  Text,
  {
    emptyLabel: 'Text',
    isEmpty: function (props) {
      return !props || !props.text || props.text.trim().length < 1
    },
    resourceType: 'wknd-spa-vue/components/text'
  }
)

// Theme Toggler Component Mapping
MapTo('wknd-spa-vue/components/theme-toggler')(
  ThemeToggler,
  {
    emptyLabel: 'ThemeToggler',
    isEmpty: (props) => {
      return !props || !props.src || props.src.trim().length < 1
    },
    resourceType: 'wknd-spa-vue/components/theme-toggler'
  }
)

// Products Component Mapping
MapTo('wknd-spa-vue/components/products')(
  Products,
  {
    emptyLabel: 'Products',
    isEmpty: (props) => {
      return !props || !props.src || props.src.trim().length < 1
    },
    resourceType: 'wknd-spa-vue/components/products'
  }
)

// AppPage Mapping
MapTo('wknd-spa-vue/components/page')(withComponentMappingContext(AppPage))
