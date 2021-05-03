import SwiftUI
import imgur.browser.common
import Nuke
import FetchImage
import SDWebImageSwiftUI

struct ContentView: View {
    @StateObject var viewModel = GallerySearchViewModel(repository: ImgurRepository(imgurApi: ImgurApi()))
    
    @State var query: String = ""
    var body: some View {
        VStack(alignment: .center, content: {
            SearchBar(text: $viewModel.query)
                .padding(.top, 30)
            GalleryList(viewModel: viewModel)
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct GalleryList: View {
    @ObservedObject var viewModel: GallerySearchViewModel
    let gridItems = Array(repeating: GridItem(.fixed(100), spacing: 0), count: 4)
    
    var body: some View {
        
        ScrollView(.vertical) {
            LazyVGrid(columns: gridItems, alignment: .center, spacing: 1) {
                if let unwrappedGalleries = viewModel.galleries {
                ForEach((unwrappedGalleries.data), id: \.self) { data in
                    let coverUrl = { () -> String in
                        if data.is_album {
                            return "https://i.imgur.com/\(data.cover).jpg"
                            
                        } else {
                            return data.link
                        }
                    }()
                    if let url = URL(string: coverUrl) {
                        ImageRow(description: coverUrl, url:url)
                    }
                }
            }
        }
    }
    }
}

struct ImageRow: View {
    let description: String
    let url: URL
    @StateObject var image = FetchImage()
    var body: some View {
        VStack(alignment: .center) {
            
            WebImage(url: url)
                .resizable()
                .placeholder(Image(systemName: "photo"))
                .indicator(.activity)
                .transition(.fade(duration: 0.5)) // Fade Transition with duration
                .clipped()
                .frame(width: 100, height: 100, alignment: .center)
    }
}
}
