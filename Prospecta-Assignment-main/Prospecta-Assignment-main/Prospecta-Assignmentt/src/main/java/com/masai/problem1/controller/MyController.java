
@RestController
public class MyController {

	@Autowired
	private EntryService service;
	
	@GetMapping("checking")
	public String checking() {
		return "working fine...";
	}
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDto>> getTitlesAndDescriptionsHandler(@PathVariable("category") String category) throws EntryException{
		
		
		List<EntryDto> entryDtos = service.getTitlesAndDesctriptions(category);
		
		
		return new ResponseEntity<List<EntryDto>>(entryDtos,HttpStatus.OK);
	}
	
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry) {
		
		Entry savedObj = service.saveEntry(entry);
		
		return new ResponseEntity<Entry>(savedObj,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
}
